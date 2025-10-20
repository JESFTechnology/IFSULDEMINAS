import pymysql


class DatabaseConnection:
    def __init__(self, host, database, user, password):
        self.host = host
        self.database = database
        self.user = user
        self.password = password
        self.connection = None

    def connect(self):
        try:
            self.connection = pymysql.connect(
                host=self.host,
                database=self.database,
                user=self.user,
                password=self.password,
            )
            print("Connection successful")
        except pymysql.MySQLError as e:
            return "Não foi possível conectar ao banco de dados."

    def get_cursor(self):
        if self.connection:
            return self.connection.cursor()
        else:
            raise Exception("Banco de dados offlie. Tente novamente mais tarde.")

    def close(self):
        if self.connection:
            self.connection.close()
            print("Connection closed")
