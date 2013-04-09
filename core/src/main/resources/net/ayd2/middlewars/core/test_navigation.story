Scenario: when the user navigates within the world should not fall out of it.

Given map dimensions
Given avatar position
When the user navigates in the world
Then see that never leave the boundaries

