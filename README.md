# Simulación de Sistemas TP1

// TODO el resto del readme

### Jupyter Lab
Se requiere tener instalado python y pip.

Desde el root del proyecto correr:
```bash
pip install pipenv
```
Para el entorno virtual. Si estás en MAC/Linux puede que funcione con pip3.

Luego correr:
```bash
pipenv install
```
Para crear la máquina virtual e instalar las dependencias.

Finalmente para abrir el JupyterLab dónde se realizaron los gráficos correr el comando
```bash
pipenv un jupyter lab
```
Y desde la lista de archivo a la izquierda, abrir `Analysis.ipynb`

### Correr el programa en consola

Se puede correr el programa por consola asi 
```bash
./run.sh  -Dargumento=valor
```
Donde los argumentos posibles son los siguientes:
    "static"; Ruta al archivo estatico 
    "dynamic"; Ruta al archivo dinamico
    "generate"; Si se desea generar o no aleatoriamente las particulas
    "N"; Cantidad de particulas
    "L"; Tamaño del dominio
    "M"; Cantidad de celdas
    "ID"; Particula a resaltar en grafico
    "r"; Radio de las particulas generadas. Si fixed=false las particulas tendran radios aleatorios entre [0,r)
    "rc"; Radio de busqueda de vecinos
    "bound-periodicity"; Setear en true si se quiere usar condiciones periodicas de contorno
    "fixed"; Usar el mismo r para todas las particulas aleatoriamente generadas
    "graph"; Mostrar el grafico
    "save"; guardar el grafico