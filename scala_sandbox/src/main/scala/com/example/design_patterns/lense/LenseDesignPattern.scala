package com.example.design_patterns.lense
/*
import monocle.Lens
import monocle.macros.GenLens

// 1. Define your nested case classes
case class Address(street: String, city: String)
case class Person(name: String, address: Address)

// 2. Create an instance of Person
val person = Person("Alice", Address("Main St", "NYC"))

// 3. Create lenses
val addressLens: Lens[Person, Address] = GenLens[Person](_.address)
val cityLens: Lens[Address, String] = GenLens[Address](_.city)

// 4. Compose lenses to focus on the city
val personCityLens: Lens[Person, String] = addressLens.composeLens(cityLens)

// 5. Use the lens to get the city
val city = personCityLens.get(person)  // "NYC"

// 6. Use the lens to set a new city immutably
val updatedPerson = personCityLens.set("LA")(person)
*/
// Print results
println(s"Original city: $city")                  // Original city: NYC
println(s"Updated person: $updatedPerson")       // Updated person: Person(Alice,Address(Main St,LA))