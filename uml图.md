@startuml
class Command {
    -String CommandWord
    -String secondWord
    +Command(firstWord,secondWord)
    +getCommandWord() String
    +getSecondWord() String
    +isunknown() boolean
    +hasSecondWord() boolean
}
class CommandWords {
     -String[] validCommands
     +CommandWords()
     +isCommand() bollean
     +showall() void
}
class Game{
     -Room currentroom
     -Paser paser
     +Game()
     -creatRooms() void
     +play()void
     -goRoom(command) void
     -printHelp() void
     -printWelcome() void
     -processCommand(Command)void
     -quit(command) bollean 
}
class Parser{
     -CommandWords commands
     -Scanner reader
     +parser()
     +getCommand()Command
     +showCommands()void
}
class Room{
     -String description
     -HashMap <String,Room>exits
     +Room(String)
     +getExit(String)Room
     -getExitString()String
     +getLongDescription() String
     +getShortDescription()String
     +setExit(String,room)void
}
Command o-- CommandWords
Parser <.. Game
Command <..Parser
Room <-- Game 
Command<..Game
@enduml