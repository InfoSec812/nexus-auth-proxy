Sonatype Nexus Token Authentication Proxy
=========================================

## Purpose

To provide token authentication capabilities to Sonatype Nexus OSS
by using the Remote User Token headers available in Nexus

## Operation
This application maintains an embedded HSQLDB database of user<->token mappings
which when properly verified will set the REMOTE_USER header for requests 
proxied to the Nexus server. This application also provides a web application
which allows for the management of the user tokens. That web application uses
an authentication request to the Nexus server's REST API to authenticate
the user.

## Prerequisites
* Java JDK >= 1.7
* Maven >= 3.0
* Internet Access (to download dependencies)

## Building

```bash
mvn clean package
```

## Running (In Development)

```bash
mvn exec:java -Dexec.args="--listen 127.0.0.1 --listen-port 8080 --target 127.0.0.1 --target-port 8980"
```

## Configuration

Running the application with the argument "--config /path/to/config.json" will 
allow the user to load the configuration options from a JSON formatted config
file. An example of this configuration file can be found in the root of this
project.

