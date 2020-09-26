# Room surface calculator application

## Table of Contents
1. [**Overview**](#Overview)
2. [**Prerequisites**](#Prerequisites)
3. [**Quick start**](#QuickStart)
4. [**Build with**](#BuiltWith)

## Overview <a name="Overview"></a>

This repository contains demo application for calculating room surface.

## Prerequisites <a name="Prerequisites"></a>

Here are some conventions that I made:
* input file has to contain rows in format numberxnumberxnumber
* number may contain decimal part

## Quick start <a name="QuickStart"></a>

### Running application

To run application you can:
* use maven - `mvn exec:java -Dexec.mainClass="io.test.Provider" -Dexec.args="src\main\resources\input1.txt"` (feel free to provide your own input file)
* use IDE - main method is located in FundsTransferApplication class

### Running tests

All tests were written in Spock. POM file was configured to compile & run groovy tests. 
To invoke them use: `./mnv clean test`

## Built with <a name="BuiltWith"></a>

* [Java 12](https://jdk.java.net/12/)
* [Maven](https://maven.apache.org/) - dependency management & build tool 
* [Spock](http://spockframework.org/) - for beautiful tests
