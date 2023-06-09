#!/bin/bash

usage() {
cat << EOF 
Remove UNREGISTERED on Star UML SVG file
EOF
}

error() {
	echo $1 && exit 1
}

if [ $# -ne 1 ]; then 
	error "Missing filename ("--help" for help)"
fi

if [ "$1" == "-help" ]; then
	usage && exit 0
fi

OS=$(uname -s)

if [ "$OS" == "Darwin" ]; then 
	if [ -e $(which gsed) ];then
		gsed -i "s/UNREGISTERED//gi" "$1"
	else 
		brew install gsed
	fi
else 
	sed -i "s/UNREGISTERED//gi" "$1"
fi