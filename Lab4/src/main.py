import lab4


def main():
    lab4.initialize()

    file_list = lab4.process_file("a1.txt")

    lab4.display_word_dictionary(file_list, 20)


if __name__ == "__main__":
    main()
