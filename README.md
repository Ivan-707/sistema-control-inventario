Se desarrollo un programa de gestión de inventario básico con el nombre sistema de control de inventario con el objetivo de administrar un inventario de manera básica, se utilizo el modelo de programación por capas separando todas las partes que son modelo, repositorio, negocio, presentación, util y excepciones, permitiendo un código más organizado, reutilizable y fácil de mantener.

En capa de modelo se creo la clase Producto que es el que se encarga de representar los datos que se ingresen este contiene los atributos de ID, Código, Nombre, Categoría, Cantidad, Precio, Disponibilidad y Descripción.

En la capa de repositorio se creó Producto Repositorio esta es la encargada de administrar los productos que son ingresados por el usuario lo que seria agregar, editar, eliminar, buscar y verificar códigos.

En la capa de negocio se creó la clase ProductoNegocio, donde está toda la lógica principal: validar datos obligatorios, revisar cantidades y precios, evitar códigos repetidos, ordenar productos por nombre, precio o cantidad, generar estadísticas del inventario y lanzar excepciones personalizadas cuando hay errores.

La capa de presentación se hizo con Java Swing. Se diseñó un JFrame con barra de menú, barra de herramientas y pestañas (JTabbedPane). Cada pestaña sirve para registrar productos, ver el inventario o consultar estadísticas. En el registro se usan componentes como JTextField, JComboBox, JCheckBox, JRadioButton, JTextArea y JButton. El inventario se muestra en un JTable, donde se puede buscar, filtrar por categoría, editar, eliminar con confirmación y ordenar la información.

El módulo de estadísticas muestra datos como: cantidad total de productos, disponibles y no disponibles, unidades almacenadas, el producto más caro y el más barato, cuántos hay por categoría y el valor total del inventario.

En cuanto al manejo de excepciones, se crearon clases personalizadas como DatoInvalidoException, ProductoDuplicadoException y ArchivoException. Además, se usaron try, catch, throw y throws para controlar los errores en tiempo de ejecución.
Finalmente, se agregó una utilidad para la exportación del inventario, que permite guardar los datos en un archivo CSV o TXT usando JFileChooser, de modo que el usuario elija dónde guardar la información.
También tu un problema al momento por una librería que no se estaba reconociendo ya que una parte del trabajo lo realice desde otra computadora y instale mal el NetBeans pero lo solucione instalando la libre gracias a un tutorial de YouTube. 
