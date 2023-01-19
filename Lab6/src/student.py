import mysql.connector



# #####################################################################################
class Student:

    def __init__(self, oid: str, name: str, email: str, standing: str, gpa: int):
        self.__name = name
        self.__email = email
        self.__standing = standing
        self.gpa = gpa
        self.__id = oid

    def __str__(self):
        return f"""{self.name:<20} - {self.id:^10} - {self.email:<50} - Standing: {self.standing}"""

    @property
    def name(self):
        return self.__name

    @property
    def email(self):
        return self.__email

    @property
    def id(self):
        return self.__id

    @property
    def standing(self):
        return self.__standing

    @property
    def gpa(self):
        return self.__gpa

    @gpa.setter
    def gpa(self, value: float):
        if 0 <= value <= 4:
            self.__gpa = value

    # #################### LOADING DATA FROM DATABASE ####################

    # -----------------------------------------------------------------------------------------------------------------
    def load(self, db_config: dict):
        """
        Loads the data for the current object. Assume id is loaded in the object.
        :param db_config: a dictionary as described in Readme.md with the connection information.
        """
        # implement Student.load


        my_db = mysql.connector.connect(host=db_config["hostname"], port=db_config["port"],
                                        user=db_config["user"], password=db_config["passwd"],
                                        database=db_config["database"])
        cursor = my_db.cursor()
        cursor.execute("SELECT id, name, email, standing, gpa "
                       "FROM university.student WHERE id=%s ", (self.__id,))

        for row in cursor.fetchall():
            self.__name = row[1]
            self.__email = row[2]
            self.__standing = row[3]
            self.__gpa = row[4]


        cursor.close()
        my_db.close()



    # ----------------------------------------------------------------------------------------
    def load_all(db_config: dict) -> []:
        """
        Class method.
        Loads all the students and returns the list
        :param db_config: a dictionary as described in Readme.md with the connection information.
        :return the list of all loaded students from the db.
        """
        # implement Student.load_all


        students = []
        my_db = mysql.connector.connect(host=db_config["hostname"], port=db_config["port"],
                                        user=db_config["user"], password=db_config["passwd"],
                                        database=db_config["database"])
        cursor = my_db.cursor()
        cursor.execute("SELECT id FROM university.student")

        for row in cursor.fetchall():
            student = Student(oid=row[0],name="", email="",standing="",gpa=0)
            # students.append(Student(oid=row[0], name=row[1], email=row[2], standing=row[3], gpa=row[4]))
            student.load(db_config)
            students.append(student)

        cursor.close()
        my_db.close()

        return students



    # -----------------------------------------------------------------------------------------------------------------
    def load_by_name(db_config: dict, name: str) -> []:
        """
        Class method.
        Loads all the students with "name" in the student's name.
        The search should be done in the DB and is case insensitive.
            Hint: remember that `like "%abc%"` will return all rows where abc is anywhere in the column.
        :param db_config: a dictionary as described in Readme.md with the connection information.
        :param name: student's name to search for.
        :return: the list of all loaded students from the db.
        """
        # implement Student.load_by_name


        students = []
        my_db = mysql.connector.connect(host=db_config["hostname"], port=db_config["port"],
                                        user=db_config["user"], password=db_config["passwd"],
                                        database=db_config["database"])
        cursor = my_db.cursor()
        cursor.execute("SELECT name, id, email, standing, gpa FROM university.student WHERE name LIKE upper(%s)", (name,))

        for row in cursor.fetchall():
            # student = Student(oid=row[0], name=row[1], email=row[2], standing=row[3], gpa=row[4])
            student = Student(oid=row[1], name=row[0], email=row[2], standing=row[3], gpa=row[4])
            student.load(db_config)
            students.append(student)

        cursor.close()
        my_db.close()

        return students
