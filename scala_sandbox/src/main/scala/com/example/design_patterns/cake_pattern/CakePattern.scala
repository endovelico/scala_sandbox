package com.example.design_patterns.cake_pattern

class CakePattern {

  // STEP 1 Define Domain Models
  case class Team(id: Int, name: String)
  case class Game(home: Team, away: Team, homeScore: Int, awayScore: Int)

  // Step 2 Team Repository Component
  trait TeamRepositoryComponent {
    val teamRepository: TeamRepository

    trait TeamRepository {
      def findTeam(id: Int): Team
    }
  }

  trait InMemoryTeamRepositoryComponent extends TeamRepositoryComponent {
    val teamRepository = new TeamRepository {
      private val teams = Map(
        1 -> Team(1, "Kansas City Chiefs"),
        2 -> Team(2, "San Francisco 49ers")
      )

      def findTeam(id: Int): Team = teams(id)
    }
  }

  trait GameRepositoryComponent {
    val gameRepository: GameRepository

    trait GameRepository {
      def findAllGames(): List[Game]
    }
  }

  trait InMemoryGameRepositoryComponent extends GameRepositoryComponent {
    self: TeamRepositoryComponent =>   // 👈 dependency declared

    val gameRepository = new GameRepository {
      def findAllGames(): List[Game] = {
        List(
          Game(teamRepository.findTeam(1), teamRepository.findTeam(2), 28, 24)
        )
      }
    }
  }

  // Step 3
  trait StandingsServiceComponent {
    self: GameRepositoryComponent =>   // 👈 dependency declared

    val standingsService: StandingsService

    trait StandingsService {
      def totalPoints(): Int
    }
  }

  trait DefaultStandingsServiceComponent extends StandingsServiceComponent {
    self: GameRepositoryComponent =>

    val standingsService = new StandingsService {
      def totalPoints(): Int =
        gameRepository.findAllGames()
          .map(g => g.homeScore + g.awayScore)
          .sum
    }
  }

  // Step 4
  object NFLApplication
    extends InMemoryTeamRepositoryComponent
      with InMemoryGameRepositoryComponent
      with DefaultStandingsServiceComponent

  object Main extends App {
    println(NFLApplication.standingsService.totalPoints())
  }

  // why this is powerful
  /*trait MockGameRepositoryComponent extends GameRepositoryComponent {
    val gameRepository = new GameRepository {
      def findAllGames() = Nil
    }
  }*/
}
