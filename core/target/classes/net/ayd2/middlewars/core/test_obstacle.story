Scenario: the user hits an obstacle, it must stop and not cross the obstacle.

Given location of obstacles
Given avatar position
When the user moves the world and encounters an obstruction
Then you must stop and not to cross the road