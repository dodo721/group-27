# Use Case 4: Produce a Report on Country Statistics

## CHARACTERISTIC INFORMATION

### Goal in Context

As a ***Data Analyst***, I want to generate a ***Country Report***, including data such as country code, for ***statistical analysis*** for further usage by my organisation.

### Scope

System.

### Level

User Goal.

### Preconditions

The system is expected to function as normal.

Data Analyst is expected to understand how to use the system/generate reports.

The contents of the database is understood to contain: *Country Code, Country Name, Continent, Region, Surface Area, Year of Independence, Population, Life Expectancy, GNP, GNPOld, Local/Native Country Name, Government Form, Head of State Name, Capital ID, and Country 'Code2'. This is to be from the 'country' table. The 'city' table must also contain City Name and CountryCode.*
  
### Success End Condition

System produces a Country Report containing: *Country Code, Country Name, Continent, Region, Population, and Capital City.*

### Failed End Condition

Incorrect data is provided to the Data Analyst - **Severe**.

OR

A report cannot be produced and error is thrown.

### Primary Actor

Data Analyst.

### Trigger

Data Analyst uses System Interface to generate Country Report.

## MAIN SUCCESS SCENARIO

1. Data Analyst opens system interface and selects desired query/report, Country in this context.
2. Data Analyst sends query.
3. Data Analyst is provided with report containing Country Statistics.
4. Data Analyst uses report for statistical analysis and provides processed data to relevant personnel.

## EXTENSIONS

1. Connection Link issue to Database (e.g. Database Down, Local Network Issue, etc.).
   1. Data Analyst informs Database Administrator and or IT Department of issue.
2. Database is corrupted causing loss of information.
    1. Data Analyst informs Database Administrator.

## SUB-VARIATIONS

????

## SCHEDULE

**DUE DATE**: 0.1.0.3 (17/02/2020)