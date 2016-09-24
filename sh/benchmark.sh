#!/bin/bash

BROWSER_NAME=$1
PORT=$2
BASE_URL="http://localhost:"${PORT}

MILLIS_GET=0
MILLIS_FIND_ELEMENT_BY_ID=0
MILLIS_CLEAR=0
MILLIS_SEND_KEYS=0
MILLIS_FIND_ELEMENT_BY_CSS=0
MILLIS_CLICK=0
MILLIS_GET_SCREENSHOT=0

RESPONSE=$(curl --silent --request "POST" \
    --data '{"desiredCapabilities":{"browserName":"'${BROWSER_NAME}'"},"requiredCapabilities":{}}' \
    ${BASE_URL}"/session")
SESSION_ID=$(echo ${RESPONSE} | \
    sed -e 's/^.*"sessionId":"\([^"]*\)".*/\1/g')

for index in $(seq 0 99); do

    START_TIME=$(php -r "echo microtime(true) * 1000;")
    RESPONSE=$(curl --silent --request "POST" \
        --data '{"url":"http://example.selenium.jp/reserveApp/"}' \
        ${BASE_URL}"/session/"${SESSION_ID}"/url")
    END_TIME=$(php -r "echo microtime(true) * 1000;")
    MILLIS_GET=$(php -r "echo ${MILLIS_GET} + ${END_TIME} - ${START_TIME};")

    START_TIME=$(php -r "echo microtime(true) * 1000;")
    RESPONSE=$(curl --silent --request "POST" \
        --data '{"using":"id","value":"guestname"}' \
        ${BASE_URL}"/session/"${SESSION_ID}"/element")
    END_TIME=$(php -r "echo microtime(true) * 1000;")
    MILLIS_FIND_ELEMENT_BY_ID=$(php -r "echo ${MILLIS_FIND_ELEMENT_BY_ID} + ${END_TIME} - ${START_TIME};")
    ELEMENT_ID=$(echo ${RESPONSE} | \
        sed -e 's/^.*"ELEMENT":"\([^"]*\)".*$/\1/g')

    START_TIME=$(php -r "echo microtime(true) * 1000;")
    RESPONSE=$(curl --silent --request "POST" \
        ${BASE_URL}"/session/"${SESSION_ID}"/element/"${ELEMENT_ID}"/clear")
    END_TIME=$(php -r "echo microtime(true) * 1000;")
    MILLIS_CLEAR=$(php -r "echo ${MILLIS_CLEAR} + ${END_TIME} - ${START_TIME};")

    START_TIME=$(php -r "echo microtime(true) * 1000;")
    RESPONSE=$(curl --silent --request "POST" \
        --data '{"value":["2014"]}' \
        ${BASE_URL}"/session/"${SESSION_ID}"/element/"${ELEMENT_ID}"/value")
    END_TIME=$(php -r "echo microtime(true) * 1000;")
    MILLIS_SEND_KEYS=$(php -r "echo ${MILLIS_SEND_KEYS} + ${END_TIME} - ${START_TIME};")

    START_TIME=$(php -r "echo microtime(true) * 1000;")
    RESPONSE=$(curl --silent --request "POST" \
        --data '{"using":"id","value":"plan_b"}' \
        ${BASE_URL}"/session/"${SESSION_ID}"/element")
    END_TIME=$(php -r "echo microtime(true) * 1000;")
    MILLIS_FIND_ELEMENT_BY_CSS=$(php -r "echo ${MILLIS_FIND_ELEMENT_BY_CSS} + ${END_TIME} - ${START_TIME};")
    ELEMENT_ID=$(echo ${RESPONSE} | \
        sed -e 's/^.*"ELEMENT":"\([^"]*\)".*$/\1/g')

    START_TIME=$(php -r "echo microtime(true) * 1000;")
    RESPONSE=$(curl --silent --request "POST" \
        ${BASE_URL}"/session/"${SESSION_ID}"/element/"${ELEMENT_ID}"/click")
    END_TIME=$(php -r "echo microtime(true) * 1000;")
    MILLIS_CLICK=$(php -r "echo ${MILLIS_CLICK} + ${END_TIME} - ${START_TIME};")

    START_TIME=$(php -r "echo microtime(true) * 1000;")
    RESPONSE=$(curl --silent --request "GET" \
        ${BASE_URL}"/session/"${SESSION_ID}"/screenshot")
    END_TIME=$(php -r "echo microtime(true) * 1000;")
    MILLIS_GET_SCREENSHOT=$(php -r "echo ${MILLIS_GET_SCREENSHOT} + ${END_TIME} - ${START_TIME};")
    #echo ${RESPONSE} | \
    #    sed -e 's/^.*"value":"\([^"]*\)".*$/\1/g' | \
    #    tr -d '\n' | \
    #    base64 --decode --output sample.png

done

RESPONSE=$(curl --silent --request "DELETE" \
    ${BASE_URL}"/session/"${SESSION_ID})

echo "get: "$(php -r "echo ${MILLIS_GET} / 100;")" millisec."
echo "findElementById: "$(php -r "echo ${MILLIS_FIND_ELEMENT_BY_ID} / 100;")" millisec."
echo "WebElement.clear: "$(php -r "echo ${MILLIS_CLEAR} / 100;")" millisec."
echo "WebElement.sendKeys: "$(php -r "echo ${MILLIS_SEND_KEYS} / 100;")" millisec."
echo "findElementByCSS: "$(php -r "echo ${MILLIS_FIND_ELEMENT_BY_CSS} / 100;")" millisec."
echo "WebElement.click: "$(php -r "echo ${MILLIS_CLICK} / 100;")" millisec."
echo "getScreenshot: "$(php -r "echo ${MILLIS_GET_SCREENSHOT} / 100;")" millisec."