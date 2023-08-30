#!/bin/bash

LINK_TO_APK_FILE_IN_GCP="TEST FILE"

echo ${LINK_TO_APK_FILE_IN_GCP}
export LINK_TO_APK_FILE_IN_GCP
testing_echo() {
    echo ${LINK_TO_APK_FILE_IN_GCP}
}
