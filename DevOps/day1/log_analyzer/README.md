# Server Log Analyzer

A beginner Linux + Git + GitHub mini project that simulates a real-world task of analyzing server log files using Linux command-line tools and tracking development using Git.

## Project Objective

The goal of this project is to:

- Practice Linux commands
- Work with files and directories
- Analyze log data
- Write and run shell scripts
- Use Git for version control
- Push and manage a GitHub repository

---

## Project Structure

```bash
log-analyzer/
├── logs/
│   └── server.log
│
├── output/
│   ├── line_count.txt
│   ├── error_count.txt
│   ├── errors_only.txt
│   ├── warnings_only.txt
│   └── top_words.txt
│
├── scripts/
│   └── analyze.sh
│
└── README.md
```

---

## Features

- Counts total log entries
- Counts ERROR messages
- Extracts ERROR logs
- Extracts WARNING logs
- Finds frequently repeated words
- Automates analysis using a shell script

---

## Linux Commands Practiced

This project uses commands such as:

```bash
mkdir
touch
cat
echo
grep
awk
cut
sort
uniq
wc
tr
head
tail
chmod
```

---

## Running the Project

Go to project directory:

```bash
cd log-analyzer
```

Make the script executable:

```bash
chmod +x scripts/analyze.sh
```

Run the script:

```bash
./scripts/analyze.sh
```

---

## Sample Log Entry

```bash
2026-05-27 INFO User login successful
2026-05-27 ERROR Database connection failed
2026-05-27 WARNING High CPU usage
2026-05-27 INFO File uploaded
2026-05-27 ERROR Payment API timeout
```

---

## Expected Output Files

| File | Purpose |
|--------|----------|
| line_count.txt | Total log lines |
| error_count.txt | Number of ERROR logs |
| errors_only.txt | Stores ERROR entries |
| warnings_only.txt | Stores WARNING entries |
| top_words.txt | Most repeated words |

---

## Skills Practiced

- Linux file management
- Text processing
- Shell scripting
- Git workflow
- GitHub repository management
- Basic automation
