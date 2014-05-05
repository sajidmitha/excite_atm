# *************************************************************************

# *************************************************************************
# START 
export JAVA_HOME="/sk/home/bea103/jdk160_05"
export ANT_HOME="/sk/home/bea103/modules/org.apache.ant_1.6.5"
export PATH="/sk/home/bea103/jdk160_05/jre/lib/rt.jar:/sk/home/bea103/jdk160_05/lib/tools.jar:/sk/home/bea103/jdk160_05/bin:/sk/home/bea103/modules/org.apache.ant_1.6.5/bin:${PATH}"
export CLASSPATH=".:./build/classes:./lib/junit-4.11.jar:./lib/hamcrest-all-1.3.jar:/sk/home/bea103/jdk160_05/bin:/sk/home/bea103/modules/org.apache.ant_1.6.5/bin:${CLASSPATH}"
echo "CLASSPATH:" ${CLASSPATH}
echo "PATH:" ${PATH}
<<<<<<< HEAD
echo "ANT_HOME:" ${ANT_HOME}
java com.excite.atm.main.ATMMain
=======
ant
java com.excite.atm.main.ATMMain
#java com.excite.atm.test.AllTests
>>>>>>> c7aa1adf2f554d8aabdad03e7ba4a49853fdf83c
