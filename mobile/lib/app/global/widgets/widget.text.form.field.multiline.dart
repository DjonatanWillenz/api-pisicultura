import 'package:flutter/material.dart';

class DwTextFieldMultLine extends StatelessWidget {
  final String label;
  final IconData icon;
  final bool isPassword;
  final TextEditingController controll;
  final Color colorIcon;
  final Function funValidarCampo;
  final bool isNotNull;

  const DwTextFieldMultLine({
    Key key,
    this.isPassword = false,
    this.label,
    this.icon,
    this.controll,
    this.colorIcon,
    this.funValidarCampo,
    this.isNotNull = false,
  }) : super(key: key);

  validarCampo(value) {
    if (isNotNull && value.isEmpty)
      return "O campo é de preenchimento obrigatório.";

    if (isNotNull && (value.length < 8))
      return 'O campo precisa ter mais de 8 caracteres.';
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Padding(
        padding: const EdgeInsets.only(left: 15, right: 15, top: 4, bottom: 8),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: Text(
                label ?? 'Sem descrição',
                style: TextStyle(
                  fontSize: 15,
                ),
                textAlign: TextAlign.start,
              ),
            ),
            TextFormField(
              controller: controll,
              maxLines: 7,
              minLines: 7,
              textAlign: TextAlign.start,
              keyboardType: TextInputType.multiline,
              decoration: InputDecoration(
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(14),
                ),
                fillColor: Colors.amberAccent,
                // prefixIcon: Icon(icon) ?? Icon(Icons.home_filled, color: colorIcon),
                hintText: 'adicione uma descrição...',
                labelStyle: TextStyle(
                  fontSize: 14,
                ),
              ),
              style: TextStyle(fontSize: 14),
              obscureText: isPassword,
              validator: (value) => validarCampo(value),
            ),
          ],
        ),
      ),
    );
  }
}
