#!/bin/bash
#
# Usages:
# run_application.sh -> Build applcation, Run tests and start Tomcat7
# run_application.sh -> Build applcation, IGNORE tests and start Tomcat7
# run_application.sh -> Build applcation, Run tests and start Tomcat7 IN DEBUG MODE
# run_application.sh -> Build applcation, IGNORE tests and start Tomcat7 IN DEBUG MODE

set -e
if ! hash mvn 2>/dev/null; then
    echo "Maven is not on  the oathm is it installed?"
    exit 1
fi

BUILD_COMMAND="mvn clean install"
START_COMMAND="mvn tomcat7:run"

if [ "$1" = '-d' ]; then
    START_COMMAND="mvndebug tomcat7:run"
elif [ "$1" = '-i' ]; then
    BUILD_COMMAND="mvn clean install -Dmaven.test.skip=true"
elif [ "$1" = '-id' -o "$1" = '-di' ]; then
    BUILD_COMMAND="mvn clean install -Dmaven.test.skip=true"
    START_COMMAND="mvndebug tomcat7:run"
fi

$BUILD_COMMAND && cd war && $START_COMMAND