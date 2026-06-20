package com.example.design_patterns.structural
package com.example.design_patterns.structural

// Subsystems
trait Downloader { def download(url: String): String }
trait Decoder { def decode(data: String): String }
trait Deserializer[T] { def parse(data: String): T }

// Facade
class DataReader[T](downloader: Downloader, decoder: Decoder, deserializer: Deserializer[T]) {
  def read(url: String): T = {
    val data = downloader.download(url)
    val decoded = decoder.decode(data)
    deserializer.parse(decoded)
  }
}

object FacadeExample extends App {
// Client usage
  //val reader = new DataReader[Person](new DownloaderImpl, new DecoderImpl, new DeserializerImpl)
  //val person = reader.read("https://example.com/person.json")

}