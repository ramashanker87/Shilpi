#!/usr/bin/env bash
set -euo pipefail
echo "prerequisites "
echo "==================="
apt-get update && apt-get --yes --force-yes install jq
jq --version
mkdir -p /workdir/local/scripts/tmp
