# Readme

> This is a javafx based project, using the MVC model, using five design patterns to complete a breakout game.

### Design Ideas

1. **MVC model**: The game adopts the Model-View-Controller (MVC) architecture, which manages business logic, interface and user input separately. This improves the maintainability and extensibility of the code. For example, the model part handles the game data and logic, the view part is responsible for displaying the UI, and the controller handles user input and coordinates the interaction between the model and the view.

2. **Five Design Patterns**: A variety of design patterns are used in the game, which help standardise the code structure and enhance the flexibility of feature implementation. The following are examples of five possible design patterns:
   
   - **Single instance pattern**: Ensures that certain objects (e.g., the game configuration manager) have only one instance in the entire application for easy global access.
   - **Observer Pattern**: Used to enable dynamic updates between the view and the model, automatically notifying the view to update its display when model data changes.
   - **Strategy Pattern**: allows different breakout strategies (e.g. character movement strategy, enemy behaviour strategy, etc.) to be used in the game, facilitating flexible switching at runtime.
   - **Factory Pattern**: Used to create different types of game objects (e.g., characters, enemies, props), simplifying the instantiation process through factory methods and improving code scalability.
   - **Adapter Pattern**: In the game, adapter pattern can be used to solve the problem of interface incompatibility between different classes. For example, when creating different map contents in the game, you can just call a unified interface directly.

### Test cases:

1. test case 0: MainTest, which starts the entry function of the javafx application, so that you can directly test the completion of the entire game.

2. Test case 1: HomePageTest, you come to the home screen. 3.

3. test case 2: OptionPageTest, used to test the Option page after entering the game interface, in which you can select the character and save it in GameState. 4. test case 3: MatchPageTest, which starts the javafx application entry function directly.

4. Test case 3: MapPageTest, you can select the map and save it in GameState.

5. test case 4: InformationPageTest, you can check some information about this game.

6. Test case 5: ScorePageTest, you can set the value of GameState to control the score displayed in ScorePage.

7. Test case 6: Level1Test, you can test the first level.

8. Test case 7: Level2Test, you can test the second level.

### Some advanced design (Addition)

1. Use of abstract classes

> By creating the abstract analogue Movable, we derive two classes, LineMove and NoMove, so we define MovableNode (including its derived classes EnemyNode and MovableObjectNode) to own the object of Movable, and we can use step_move to Call the step_move function of the different derived classes of Movable to complete the move of the Node.  
> This design greatly reduces duplication of code. 
> This design greatly reduces repetitive code, every time you add a new monster, you only need to inherit from EnemyNode, and if the monster is static, you can set its Movable member to NoMove, in this way, in every computation frame, its step_move will not be called to generate movement. This unifies the interface for moving all movable objects (creatures, platforms, etc.).

2. Give moving objects in the game a range of movement.

> By using iterators and arrays together, when initialising the map content, the ranges are taken out of the iterator one by one and then applied to the moving objects.

3. Moving object turning back

> A moving object when going back will reverse the image mirror and then the displacement moves in the negative direction as a way to achieve this effect.

4. Mapping each Entity

> Through the string EntityType, combined with switch to achieve, and the picture will be returned to the relevant Node object, so as to achieve each new entity, only need to add a case and a few related classes to achieve.

5. Timer Logic

> After the level starts, a timer will be prevented in the window, starting from 5 minutes even if it is an AnimationTimer object, and the timeLabel will be modified to achieve this effect before 1s passes, and it will come in handy during the final scoring.


