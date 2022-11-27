import re
from typing import TextIO

import nltk


def initialize():
    # initialize the nltk module
    nltk.download('stopwords')
    nltk.download('punkt')


def process_file(filename: str):
    """ Given a filename opens the file and counts how many times each word appears in the file"""

    word_count = {}  # will store word:qty

    file: TextIO
    with open(filename, mode="r", encoding="utf8") as file:
        while line := file.readline():
            count_line_words(line, word_count)

    return word_count


def count_line_words(line: str, word_count: dict):
    all_stopwords = [nltk.corpus.stopwords.words("english", "br")]

    tokenize_line = [nltk.tokenize.word_tokenize(line)]

    words_wo_stopwords = [word for word in tokenize_line if not all_stopwords and re.fullmatch("[A-Z]*[a-z]*", word)]

    for w in words_wo_stopwords:
        word_count[w] = word_count.get(w, 0) + 1


def display_word_dictionary(word_count: dict, top=15):
    top = int(top)
    top_count = 0
    for word, qty in sorted(list(word_count.items()), key=lambda x: x[1]):
       top_count +=1
       if top_count <= top:
           print(f"{word: ^20}-{qty: >15}")

       else:
           break





