# Use Case 3: Produce a Report on City Statistics

## CHARACTERISTIC INFORMATION

### Goal in Context

As a ***Data Analyst***, I want to generate a ***City Report***, including data such as population by city and enclosing district, for ***statistical analysis*** for further usage by my organisation.

### Scope

System.

### Level

User Goal.

### Preconditions

The system is expected to function as normal.

Data Analyst is expected to understand how to use the system/generate reports.

The contents of the database is understood to contain: City ID, City Name, Country Code, District, and Population from the 'city' table. The 'country' table must also contain Country Name.  
### Success End Condition

System produces a City Report containing: *City Name, Country Name, District, and City Population.*

### Failed End Condition

Incorrect data is provided to the Data Analyst - **Severe**.

OR

A report cannot be produced and error is thrown.

### Primary Actor

Data Analyst.

### Trigger

Data Analyst uses System Interface to generate City Report.

## MAIN SUCCESS SCENARIO

1. Data Analyst opens system interface and selects desired query/report, City in this context.
2. Data Analyst sends query.
3. Data Analyst is provided with report containing City Statistics.
4. Data Analyst uses report for statistical analysis and provides processed data to relevant personnel.

## EXTENSIONS

1. Connection Link issue to Database (e.g. Database Down, Local Network Issue, etc.).
   1. Data Analyst informs Database Administrator and or IT Department of issue.
2. Database is corrupted causing loss of information.
    1. Data Analyst informs Database Administrator.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 0.1.0.3 (17/02/2020)