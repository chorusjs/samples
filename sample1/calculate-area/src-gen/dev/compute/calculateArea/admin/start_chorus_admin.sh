#!/bin/sh

# this is the start up script for the chorus.js admin console
# 
# we are using meteorite
# https://github.com/oortcloud/meteorite/blob/master/README.md
#
# to install meteorite: npm install -g meteorite
#
#


command -v mrt >/dev/null 2>&1 || { echo >&2 "\n\nWARNING ***********\n\nChorus.js requires meteorite but it's not installed.\n\nUse npm to install meteorite:\n $ npm install -g meteorite\n\n\n  ... aborting."; exit 1; }
meteor add accounts-ui
meteor remove autopublish
export MONGO_URL=mongodb://localhost:27017/chorus
mrt --port 3001
