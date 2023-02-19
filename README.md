# TheMealDB Clone

TheMealDB REST API clone is a replica of famous [TheMealDB](https://www.themealdb.com/)

## Tech Stack

- Spring Boot
- H2 database

## API Reference

#### Search meal by name

```http
  GET /api/json/v1/search?s=Arrabiata
```

| Parameter |   Type   | Description                    |
|:---------:|:--------:|:-------------------------------|
|    `s`    | `string` | **Required**. Name of the meal |

#### List all meals by first letter

```http
  GET /api/json/v1/search?f=a
```

| Parameter |    Type     | Description                            |
|:---------:|:-----------:|:---------------------------------------|
|    `f`    | `character` | **Required**. First letter of the meal |

#### Lookup full meal details by id

```http
  GET /api/json/v1/lookup?i=52772
```

| Parameter |   Type   | Description                  |
|:---------:|:--------:|:-----------------------------|
|    `i`    | `String` | **Required**. Id of the meal |

#### Lookup a single random meal

```http
  GET /api/json/v1/random
```

#### Lookup a selection of 10 random meals

```http
  GET /api/json/v1/randomselection
```

#### Latest Meals

```http
  GET /api/json/v1/latest
```

#### List all meal categories

```http
  GET /api/json/v1/categories
```

#### List all areas

```http
  GET /api/json/v1/areas
```

#### List all ingredients

```http
  GET /api/json/v1/ingredients
```

#### Filter by Ingredients

```http
  GET /api/json/v1/filter?i=chicken_breast,garlic,salt
```

| Parameter |   Type   | Description                                       |
|:---------:|:--------:|:--------------------------------------------------|
|    `i`    | `String` | **Required**. comma separated list of ingredients |

#### Filter by Category

```http
  GET /api/json/v1/filter?c=Seafood
```

| Parameter |   Type   | Description                 |
|:---------:|:--------:|:----------------------------|
|    `c`    | `String` | **Required**. meal category |

#### Filter by Area

```http
  GET /api/json/v1/filter?a=Canadian
```

| Parameter |   Type   | Description        |
|:---------:|:--------:|:-------------------|
|    `a`    | `String` | **Required**. area |

## Run Locally

Clone the project

```bash
  git clone https://github.com/prithwish-samanta/mealdb-api-clone.git
```

Go to the project directory

```bash
  cd mealdb-api-clone
```

Install dependencies

```bash
  mvn clean install
```

Start the server

```bash
  mvn spring-boot:run
```

Now you can access the api on [localhost:8080](http://localhost:8080)

## Lessons Learned

- How to narrow request mappings based on request parameter conditions?
- spring-data-jpa Query methods
- Custom Spring Data Repository