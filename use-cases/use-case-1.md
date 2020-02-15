# Use Case 1: Produce a Report on Spoken Language Statistics

## CHARACTERISTIC INFORMATION

### Goal in Context

As a ***Data Analyst***, I want to generate a ***Languages Report*** containing the number of speakers and percentage of world population per language, for ***statistical analysis*** as requested by my organisation

### Scope

System.

### Level

User Goal.

### Preconditions

The system is expected to function as normal.

Data Analyst is expected to understand how to use the system/generate reports.

The contents of the database is understood to contain: *Country Code, Language, IsOfficial (Boolean), and Percentage of country that speaks language.*
### Success End Condition

System produces a Language Report containing the number of people who speak defined languages, and number of speakers as percentage of world population. **This is to be sorted by greatest number to smallest**. 

### Failed End Condition

Incorrect data is provided to the Data Analyst - **Severe**.

OR

A report cannot be produced and error is thrown.

### Primary Actor

Data Analyst.

### Trigger

Data Analyst uses System Interface to generate selected (Languages) report.

## MAIN SUCCESS SCENARIO

1. Data Analyst opens system interface and selects desired query/report, languages in this context.
2. Data Analyst sends query.
3. Data Analyst is provided with report of Languages information.
4. Data Analyst provides report to relevant personnel in department as per request. 

## EXTENSIONS

1. Connection Link issue to Database (e.g. Database down, Local Network Issue, etc.).
   1. Data Analyst informs Database Administrator and or IT Department of issue.
2. Database is corrupted causing loss of information.
    1. Data Analyst informs Database Administrator.

## SUB-VARIATIONS

????

## SCHEDULE

**DUE DATE**: 0.1.0.3 (17/02/2020)