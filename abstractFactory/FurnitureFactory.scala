trait Furniture{
    def style: String
}

trait ArtDecoStyle{
    def style: String = "ArtDeco"
}

trait VictorianStyle{
    def style: String = "Victorian"
}

trait ModernStyle{
    def style: String = "Modern"
}

trait Chair extends Furniture{
    def hasLegs: Boolean
    override def toString = s"Chair has legs? $hasLegs. Its style is $style"
}

trait Sofa extends Furniture{
    def isComfy: Boolean
    override def toString = s"Is sofa comfy? $isComfy. Its style is $style"
}

trait Table extends Furniture{
    def shape: String
    override def toString = s"The table's shape is $shape and its style is $style"
}

class ArtDecoChair extends Chair with ArtDecoStyle{
    def hasLegs: Boolean = true
}

class VictorianChair extends Chair with VictorianStyle{
    def hasLegs: Boolean = true
}

class ModernChair extends Chair with ModernStyle{
    def hasLegs: Boolean = false
}


class ArtDecoSofa extends Sofa with ArtDecoStyle{
    def isComfy: Boolean = false
}

class VictorianSofa extends Sofa with VictorianStyle{
    def isComfy: Boolean = true
}

class ModernSofa extends Sofa with ModernStyle{
    def isComfy: Boolean = true
}

class ArtDecoTable extends Table with ArtDecoStyle{
    def shape: String = "round"
}

class VictorianTable extends Table with VictorianStyle{
    def shape: String = "square"
}

class ModernTable extends Table with ModernStyle{
    def shape: String = "rectangular"
}

trait FurnitureFactory{
    def getChair: Chair
    def getSofa: Sofa
    def getTable: Table
}

class ArtDecoFurnitureFactory extends FurnitureFactory{
    def getChair: Chair = new ArtDecoChair
    def getSofa: Sofa = new ArtDecoSofa
    def getTable: Table = new ArtDecoTable
}

class VictorianFurnitureFactory extends FurnitureFactory{
    def getChair: Chair = new VictorianChair
    def getSofa: Sofa = new VictorianSofa
    def getTable: Table = new VictorianTable
}

class ModernFurnitureFactory extends FurnitureFactory{
    def getChair: Chair = new ModernChair
    def getSofa: Sofa = new ModernSofa
    def getTable: Table = new ModernTable
}

class Application(val f: FurnitureFactory){
    println(f.getChair.toString())
    println(f.getSofa.toString())
    println(f.getTable.toString())
}


object Runner{
    def main(argv: Array[String]){
        new Application(createFurnitureFactory(argv(0)))
    }

    def createFurnitureFactory(furnitureType: String): FurnitureFactory = {
        furnitureType match {
            case "ArtDeco" => new ArtDecoFurnitureFactory
            case "Victorian" => new VictorianFurnitureFactory
            case "Modern" => new ModernFurnitureFactory
        }
    }
}












