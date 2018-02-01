#!/bin/sh

## compile the project in local environment
## added by arthur.liu on 2018-01-25

mvn clean
sleep 1s

mvn eclipse:clean
sleep 1s

mvn install -Dmaven.test.skip=true
sleep 1s

mvn eclipse:eclipse
sleep 1s
