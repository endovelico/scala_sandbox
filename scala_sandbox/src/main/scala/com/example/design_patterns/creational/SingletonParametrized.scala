package com.example.design_patterns.creational

class SingletonParametrized {

  class Config private (val env: String)

  object Config {
    private var instance: Option[Config] = None

    def init(env: String): Config = {
      if (instance.isEmpty) {
        instance = Some(new Config(env))
      }
      instance.get
    }

    def get: Config = instance.getOrElse(
      throw new IllegalStateException("Config not initialized")
    )
  }

  // Usage
  val config = Config.init("production")
  println(Config.get.env) // production
}
