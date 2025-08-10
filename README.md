# Simulación de Sistemas TP1

## 👋 Introducción

Trabajo práctico para la materia de Simulación de Sistemas en el ITBA. Se buscó implementar un generador de partículas no puntuales (r>0) para posteriormente aplicar el Cell Index Method para hallar las partículas vecinas de cada una. Adicionalmente se agregó la posibilidad de ver un gráfico con las partículas y guardar dicho gráfico en una imagen.

### ❗ Requisitos

- Java 21+
- Maven
- Python3 y Pip3 (En caso de querer ver el análisis en Lab)

## 🏃 Ejecución

Se puede correr el programa por consola con el siguiente comando:
```bash
./run.sh  -Dargumento=valor
```

### 🛠️ Argumentos
Donde los argumentos posibles son los siguientes:
- `generate`: Si se desea generar o no aleatoriamente las particulas setear en true
- `static`: Ruta al archivo estatico (en caso de no generar)
- `dynamic`: Ruta al archivo dinamico (en caso de no generar)
- `N`: Cantidad de particulas
- `L`: Tamaño del dominio
- `M`: Cantidad de celdas
- `ID`: Particula a resaltar en grafico
- `r`: Radio de las particulas generadas. Si fixed=false las particulas tendran radios aleatorios entre [0,r)
- `rc`: Radio de busqueda de vecinos
- `bound-periodicity`: Setear en true si se quiere usar condiciones periodicas de contorno
- `fixed`: Para usar el mismo r para todas las particulas aleatoriamente generadas setear en true
- `graph`: Para mostrar el grafico setear en true
- `save`: Para guardar el grafico setear en true
- `show-ids`: mostrar ids en gráfico

## 🧪 Jupyter Lab
Se requiere tener instalado python y pip.

Correr desde la consola (Si estás en MAC/Linux funciona con pip3):
```bash
pip install pipenv
```
Para el entorno virtual.

Luego correr desde el root del proyecto:
```bash
pipenv install
```
Para crear la máquina virtual e instalar las dependencias.

Finalmente para abrir el JupyterLab dónde se realizaron los gráficos correr el comando
```bash
pipenv run jupyter lab
```
Y desde la lista de archivo a la izquierda, abrir `Analysis.ipynb`