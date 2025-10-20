from src.database import DatabaseConnection
from flask import Flask, jsonify, render_template, session, request, redirect

app = Flask(__name__)

db_config = {
    "host": "localhost",
    "database": "mydb",
    "user": "user",
    "password": "password",
}
db = DatabaseConnection(**db_config)


@app.route("/")
def index():
    if "logged_in" in session and session["logged_in"]:
        return render_template("main.html")
    else:
        return render_template("login.html")


@app.route("/login", methods=["GET"])
def login():
    return render_template("login.html")


@app.route("/login-check", methods=["POST"])
def login_data():
    global db
    email = request.form.get("email")
    password = request.form.get("password")
    if email == "demo@gmail.com" or password == "demo123":
        return redirect("/demo-main")
    try:
        db.connect()
        cursor = db.get_cursor()
        query = "SELECT * FROM users WHERE email=%s AND password=%s"
        cursor.execute(query, (email, password))
        user = cursor.fetchone()
        db.close()
        if user:
            session["logged_in"] = True
            return redirect("/main")
        return render_template("login.html", error="Credenciais inválidas.")
    except Exception as e:
        return render_template("login.html", error=e)


@app.route("/demo-main", methods=["GET"])
def demo_main():
    return render_template("demo-main.html")


@app.route("/data", methods=["GET"])
def get_data():
    try:
        db.connect()
        cursor = db.get_cursor()
        cursor.execute("SELECT * FROM my_table")
        results = cursor.fetchall()
        db.close()
        return jsonify(results)
    except Exception as e:
        return jsonify({"error": str(e)}), 500


if __name__ == "__main__":
    app.run(debug=True)
