wc -l < "logs/server.log" > output/line_count.txt

awk '$2 ~ /ERROR/' logs/server.log | wc -l > output/error_count.txt

awk '$2 ~ /ERROR/' logs/server.log > output/error_only.txt

awk '$2 ~ /WARNING/' logs/server.log > output/warning_only.txt

tr -s '[:space;]' '\n' < logs/server.log | grep -vwE '^[0-9-]+$' | grep -vwF -f script/stopwords.txt | sort | uniq -c | sort -nr | head -1 | awk '{print $2}'
