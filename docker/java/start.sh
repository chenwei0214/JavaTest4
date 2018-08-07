#!bin/bash
while ! nc -z ${MYSQL_IP} ${MYSQL_PORT}; do sleep 3; done
echo "========================"
echo "${MYSQL_IP}:${MYSQL_PORT}"
echo "========================"
java -cp ./Exam1.jar com.hand.Application