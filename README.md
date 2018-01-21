## Groovy Tutorial

##### A collection of tutorial groovy scripts in a containerized sandbox environment.

## Instructions

```
  docker-compose build

  docker-compose run tutorial bash
```

## Usage

##### Two windows are initialized on startup.  One window opens vim to allow script editing. ( Not required, source scripts are also volume mounted. )

##### A background command listens for when files are saved and then executes the saved script.




