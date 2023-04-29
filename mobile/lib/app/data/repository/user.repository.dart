import 'dart:convert';

import 'package:app/app/data/model/user.model.dart';
import 'package:app/app/data/provider/user.provider.dart';
import 'package:crypto/crypto.dart';

class UserRepository {
  final UserApiClient apiClient = UserApiClient();

  Future<User> auth(String username, String password, bool ehMd5) async {
    if (!ehMd5) password = textToMd5(password);
    var user = await apiClient.auth(username, password);
    return user != null ? User.fromMap(user) : null;
  }

  Future<User> post(User user) async {
    user.password = textToMd5(user.password);
    var result = await apiClient.register(user);
    return result != null ? User.fromMap(result) : null;
  }

  String textToMd5(String text) {
    return md5.convert(utf8.encode(text)).toString();
  }

  logout() async {
    await apiClient.logout();
  }
}
