package com.sksamuel.hoplite.aws

import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagementClientBuilder
import com.amazonaws.services.simplesystemsmanagement.model.GetParametersByPathRequest
import com.amazonaws.services.simplesystemsmanagement.model.Parameter
import com.sksamuel.hoplite.ConfigFailure
import com.sksamuel.hoplite.ConfigResult
import com.sksamuel.hoplite.Node
import com.sksamuel.hoplite.PropertySource
import com.sksamuel.hoplite.PropertySourceContext
import com.sksamuel.hoplite.decoder.toValidated
import com.sksamuel.hoplite.parsers.toNode

/**
 * Provides all keys under a prefix path as config values.
 *
 * Note: If the values are encrypted, you must enable withDecryption inside the [configure] block.
 *
 * @param prefix the prefix for paths to retrieve.
 * @param stripPath if true then the prefix will be stripped from each key
 * @param configure the AWS request object for custom configuration. Optional.
 *
 */
class ParameterStorePathPropertySource(
  private val prefix: String,
  private val stripPath: Boolean = true,
  private val configure: GetParametersByPathRequest.() -> Unit
) : PropertySource {

  override fun source(): String = "AWS SSM Parameter Store"

  private val client by lazy { AWSSimpleSystemsManagementClientBuilder.defaultClient() }

  private fun fetchParameterStoreValues(): Result<List<Parameter>> = runCatching {
    val req = GetParametersByPathRequest().withPath(prefix).apply(configure)
    val params = mutableListOf<Parameter>()
    tailrec fun go(request: GetParametersByPathRequest, parameters: MutableList<Parameter>): List<Parameter> {
      val result = client.getParametersByPath(request)
      return if (result.nextToken != null) {
        request.nextToken = result.nextToken
        go(request, (parameters + result.parameters).toMutableList())
      } else result.parameters + parameters
    }
    go(req, params)
  }

  override fun node(context: PropertySourceContext): ConfigResult<Node> {
    return fetchParameterStoreValues().map { params ->
      params.associate { it.name to it.value }.toNode("aws_parameter_store at $prefix", "/") {
        (if (stripPath) it.removePrefix(prefix) else it).removePrefix("/")
      }
    }.toValidated {
      ConfigFailure.PropertySourceFailure("Could not fetch data from AWS parameter store: ${it.message}", it)
    }
  }
}
