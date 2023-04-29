class Notifications {
  int id;
  int iduser;
  String title;
  String description;
  DateTime date;
  bool visualized;

  Notifications({this.title, this.description});

  Notifications.fromJson(Map<String, dynamic> json) {
    id = json['id'] ?? 0;
    iduser = json['iduser'] ?? 0;
    title = json['title'] ?? '';
    description = json['description'] ?? '';
    date = json['date'];
    visualized = json['visualized'] ?? false;
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['id'] = this.id;
    data['iduser'] = this.iduser;
    data['title'] = this.title;
    data['description'] = this.description;
    data['date'] = this.date;
    data['visualized'] = this.visualized;
    return data;
  }
}
