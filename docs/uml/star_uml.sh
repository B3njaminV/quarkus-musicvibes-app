#!/bin/bash

OS=$(uname -s)
MACOS_CMD=$(gsed -i 's/UNREGISTERED//gi' "$1")
LINUX_CMD=$(sed -i 's/UNREGISTERED//gi' "$1")

usage() {
cat << EOF 
Remove UNREGISTERED pattern on Star UML SVG file

Options : 

--help : Display usage

Arguments : 

File name to format

Example : 

bash $0 file.svg
EOF
}

error() {
	echo "$1" && exit 1
}

homebrewInstall() {
	echo "Homebrew installation"
	$(which bash) -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
	echo "Homebrew installed ✅"
}

homebrewInstallCmd() {
	brew install gsed
	"$MACOS_CMD"
}

# No argument error
if [ $# -ne 1 ]; then 
	error "Missing filename (\"--help\" for help)"
fi

# Usage  argument
if [ "$1" == "--help" ] || [ "$1" == "-h" ]; then
	usage && exit 0
fi

# Main program
if [ "$OS" == "Darwin" ]; then 
	if [ -e "$(which gsed)" ];then
		"$MACOS_CMD"
	else 
		if [ -e "$(which gsed)" ]; then 
			homebrewInstallCmd
		else
			homebrewInstall && homebrewInstallCmd
		fi
	fi
else 
	"$LINUX_CMD"
fi
