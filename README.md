# TMDB CLI app

## Description

Project done to remove my rust for Java, following the requirements of
https://roadmap.sh/projects/tmdb-cli.

## Requirements

The project requires Java and Maven installed, and an API KEY from The Movie Data Base.

Link to obtain the TMDB key: https://developer.themoviedb.org/docs/getting-started;

## Setup

Create a .env file which simply defines the api key, example as follows

```bash
TMDB_KEY="Foo bar"
```

The key in question is the **"API Read Access Token"**.

Then, within the TmdbCLI directory, source the file as follows:

```bash
source .env
```

Finally compile and execute the software as follows:

```bash
mvn exec:java -Dexec.mainClass="com.josnic.Main" -Dexec.args="--type popular"
```

### Usage of the program

```bash
Usage: --type [TYPE]
TYPE: playing: Now playing movies.
popular: Popular movies.
top: Top rated movies.
upcoming: Upcoming movies.
```
