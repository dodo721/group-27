# Use Case 5: Produce a Report on Population Statistics

## CHARACTERISTIC INFORMATION

### Goal in Context

As a ***Data Analyst***, I want to generate a ***Population Report***, including data such as total population of region, so that I can perform ***statistical analysis*** for further usage by my organisation as requested.

### Scope

System.

### Level

User Goal.

### Preconditions

The system is expected to function as normal.

Data Analyst is expected to understand how to use the system/generate reports.

The contents of the database is understood to contain: *Country Code, Country Name, Continent, Region, Surface Area, Year of Independence, Population, Life Expectancy, GNP, GNPOld, Local/Native Country Name, Government Form, Head of State Name, Capital ID, and Country 'Code2'.*
This is to be from the 'country' table. The 'city' table must also contain City Name, Country Code, and population.*
  
### Success End Condition

System produces a Population Report containing: *Continent/Region/Country Names, population of continent/region/country, percentage population of continent/region/country living in cities, and percentage population of continent/region/country **not** living in cities.*

### Failed End Condition

Incorrect data is provided to the Data Analyst - **Severe**.

OR

A report cannot be produced and error is thrown.

### Primary Actor

Data Analyst.

### Trigger

Data Analyst uses System Interface to generate Population Report.

## MAIN SUCCESS SCENARIO

1. Data Analyst opens system interface and selects desired query/report, Population in this context.
2. Data Analyst sends query.
3. Data Analyst is provided with report containing Population Statistics.
4. Data Analyst provides report to relevant personnel as per request.

## EXTENSIONS

1. Connection Link issue to Database (e.g. Database Down, Local Network Issue, etc.).
   1. Data Analyst informs Database Administrator and or IT Department of issue.
2. Database is corrupted causing loss of information.
    1. Data Analyst informs Database Administrator.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 0.1.0.3 (17/02/2020)