#  Tribes Challenge

- **Author:** [Stef Schulz](mailto:s.schulz@slothsoft.de)
- **Repository:** <https://github.com/slothsoft/challenge-tribes>
- **Open Issues:** <https://github.com/slothsoft/challenge-tribes/issues>
- **Wiki:** none


In this challenge you manage a tribe so it will grow and be able to survive the other tribes of this world.

![Screenshot](https://raw.githubusercontent.com/slothsoft/challenge-tribes/master/readme/screenshot.png)



## Getting Started

### Prerequisites

You need at least **Java 8** or above to run the code.


### Using the Challenge

1. Clone this repository
2. Import into the IDE of your choice
3. Run `TribesChallenge` to see the challenge in action
4. Create your own implementation of `Tribe` and put it into `de.slothsoft.tribes.contrib`, then run `TribesChallenge` again to see your tribe

```java   
public class MyTribe extends AbstractTribe implements Tribe {

	@Override
	public String getDisplayName() {
		return "My Tribe";
	}

	@Override
	public Color getColor() {
		return Color.YELLOW;
	}

	@Override
	public Action execute(Context context) {
		// TODO: use context to decide on an action
	}

}
```
   
  

##  Versions


| Version       | 
| ------------- |
| [Java 8](https://github.com/slothsoft/challenge-tribes) |
   

## Features

There are a couple of actions tribes do during their life, which are partially returned by the method `execute(Context):Action`:
 
| Action            | `Action`    | Source Code |
| ----------------- | ------------- | ------------------------------------------------ |
| **Skip Round**    | SETTLE        | -                                                |
| **Tribe Growths** | automatically | `Tile.executeRound()`, constants `Tribe` |
| **Movement**      | MOVE_<dir>    | `Map.executeRound()`                       |
| **Splitting up**  | SPLIT_UP      | `Map.executeRound()`                       |
| **Attacks**       | automatically | `Tile.getAttackedBy(Tile)`                |



## License

This project is licensed under the MIT License - see the [MIT license](https://opensource.org/licenses/MIT) for details.
