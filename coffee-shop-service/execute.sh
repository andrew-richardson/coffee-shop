#!/bin/bash

JBOSS_HOME=/opt/jboss/wildfly
JBOSS_CLI=$JBOSS_HOME/bin/jboss-cli.sh
JBOSS_MODE=${1:-"standalone"}
JBOSS_CONFIG=${2:-"$JBOSS_MODE.xml"}

function wait_for_server() {
    until `$JBOSS_CLI -c "ls /deployment" &> /dev/null`; do
        sleep 1
    done
}

echo "=> Starting Wildfly Server"
$JBOSS_HOME/bin/$JBOSS_MODE.sh -c $JBOSS_CONFIG > /dev/null &

echo "=> Waiting for the server to boot"
wait_for_server

echo "=> Executing the commands"
$JBOSS_CLI -c --file=`dirname "$0"`/commands.cli

echo "=> Shutting down Wildfly"
if [ "$JBOSS_MODE" = "standalone" ]; then
    $JBOSS_CLI -c ":shutdown"
else
    $JBOSS_CLI -c "/host=*:shutdown"
fi