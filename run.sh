#!/bin/bash

set -e

JAR_FILE="target/SdS-TP1-1.0-SNAPSHOT.jar"


if [[ ! -f "$JAR_FILE" ]]; then
    echo "No se encontró $JAR_FILE"
    echo "Compilá con: mvn package"
    exit 1
fi

# Clase principal (con paquete si aplica)
MAIN_CLASS="Main"


java "$@" -cp "$JAR_FILE" "$MAIN_CLASS"
