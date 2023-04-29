import 'package:app/app/global/widgets/widget_icon.dart';
import 'package:app/app/global/widgets/widget.text.dart';
import 'package:flutter/material.dart';

class DwButtonContainer extends StatelessWidget {
  final Color cor;
  final String rota;
  final String label;
  final IconData ico;

  const DwButtonContainer({
    Key key,
    this.cor = Colors.amber,
    this.rota,
    this.label = "null",
    this.ico = Icons.add,
  }) : super(key: key);

//Função para chamr a tela corespondente ao button
  void chamarRota(context) {
    Navigator.of(context).pushNamed(this.rota);
  }

  @override
  Widget build(BuildContext context) {
    var size = MediaQuery.of(context).size;
    return GestureDetector(
      onTap: () => chamarRota(context),
      child: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Container(
          decoration: BoxDecoration(
            borderRadius: BorderRadius.circular(10),
            color: cor,
          ),
          height: 110,
          width: size.width / 2 - 20,
          child: Center(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.center,
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                DwIcon(icon: ico, size: 36),
                DwText(
                  lbl: label,
                  cor: Colors.black,
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
