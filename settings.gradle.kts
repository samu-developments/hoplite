rootProject.name = "hoplite"

include(
   ":hoplite-core",
   ":hoplite-azure",
   ":hoplite-aws",
   ":hoplite-aws2",
   ":hoplite-arrow",
   ":hoplite-consul",
   ":hoplite-cronutils",
   ":hoplite-datetime",
   ":hoplite-gcp",
   ":hoplite-hdfs",
   ":hoplite-hikaricp",
   ":hoplite-hocon",
   ":hoplite-javax",
   ":hoplite-json",
   ":hoplite-micrometer-datadog",
   ":hoplite-micrometer-prometheus",
   ":hoplite-micrometer-statsd",
   ":hoplite-toml",
   ":hoplite-vault",
   ":hoplite-vavr",
   ":hoplite-watch",
   ":hoplite-watch-consul",
   ":hoplite-yaml"
)

enableFeaturePreview("STABLE_CONFIGURATION_CACHE")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
