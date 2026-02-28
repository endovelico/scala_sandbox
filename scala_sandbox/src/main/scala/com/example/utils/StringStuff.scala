package com.example.utils

class StringStuff {

  def interpolation(toIntroduce:String):String = { return s"We are interpolating $toIntroduce"}

  def f_interpolator(name:String, score:Int):String = { return f"$name, you weigh $score%0f pounds"}

  def iterate_string_one() = { "Iterating a String in Upper case".map(_.toUpper)}

  def iterate_and_filter_and_map(to_iterate:String):String = { to_iterate.filter(_ != '|').map(_.toUpper)  }

}
