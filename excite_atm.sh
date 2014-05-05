# *************************************************************************

# *************************************************************************
# START 
JAVA_HOME="/sk/home/bea103/jdk160_05"
export  JAVA_HOME
ANT_HOME="/sk/home/bea103/modules/org.apache.ant_1.6.5"
export ANT_HOME
PATH="/sk/home/bea103/jdk160_05/jre/lib/rt.jar:/sk/home/bea103/jdk160_05/lib/tools.jar:/sk/home/bea103/jdk160_05/bin:/sk/home/bea103/modules/org.apache.ant_1.6.5/bin:${PATH}"
export PATH 
CLASSPATH=".:./build/classes:./lib/junit-4.11.jar:./lib/hamcrest-all-1.3.jar:/sk/home/bea103/jdk160_05/bin:/sk/home/bea103/modules/org.apache.ant_1.6.5/bin:${CLASSPATH}"
export CLASSPATH
echo "CLASSPATH:" ${CLASSPATH}
echo "PATH:" ${PATH}
cd build/classes
java com.excite.atm.main.ATMMain
#java com.excite.atm.test.AllTests
