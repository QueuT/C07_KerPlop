Authors: Quincy Breaux and Francez Fernandez

For this project, we must implement an interactive game named KerPlop using object-oriented principles. The game includes various game pieces with different behaviors, such as movable, drawable, and interactive pieces that will influence the gameplay. This game will progress through multiple levels, with a player controlling a character while interacting with different game pieces.

The gameEngine package have: 
   - `Drawable` that interface for objects that can be drawn on the game board.
   - `GameEngine` the core logic of the game, controlling levels and game pieces.
   - `InteractionResult` is the enum that determines the result of interactions between game pieces and the player.
   - `Moveable` that interface for pieces that can move.
   - `Player` is a class representing the player's character.

The levelPieces package have:
   - `GamePiece` the abstract class for all game pieces.
   - `GhostArcher` is a ranged attacker piece that can kill the player.
   - `LevelSetup` is a class responsible for initializing and setting up game levels.
   - `MysticGuardian` is a piece that grants points to the player.
   - `PortalPad` is a piece that do nothing or drawable.
   - `RogueBeast`is a randomly moving piece that damages the player.
   - `ShadowCrawler` is a piece that is invisible at times and hits the player when on the same place.
   - `TimeCrystal` is a not movable piece that will make the player to advance in next level.
