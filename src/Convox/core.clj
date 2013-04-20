(ns Convox.core
    (:import (java.io StringWriter StringReader)
             (org.openscience.cdk.smiles SmilesParser)
             (org.openscience.cdk DefaultChemObjectBuilder ChemFile Molecule)
             (org.openscience.cdk.io DefaultChemObjectWriter SDFWriter SMILESWriter MDLV2000Reader CMLWriter)))

(defn smiles-to-cml
  " Converts a smiles string to cml
   "
  ([smiles]
      (let* [smilesParser (SmilesParser. (DefaultChemObjectBuilder/getInstance))
             molecule (.parseSmiles smilesParser smiles)
             w (StringWriter.)
             mw (CMLWriter. w)]
               (.write mw molecule)
               (.close mw)
               (.toString w))))

(defn smiles-to-sdf
  " Converts a smiles string to SDF
   "
  ([smiles]
      (let* [smilesParser (SmilesParser. (DefaultChemObjectBuilder/getInstance))
             molecule (.parseSmiles smilesParser smiles)
             w (StringWriter.)
             mw (SDFWriter. w)]
               (.write mw molecule)
               (.close mw)
               (.toString w))))

(defn sdf-to-smiles
  " Converts an SDF to smiles
   "
  ([sdf]
      (let* [reader (StringReader. sdf)
             sdfParser (MDLV2000Reader. reader)
             mol (Molecule.)
             molecule (.read sdfParser mol)
             w (StringWriter.)
             mw (SMILESWriter. w)]
               (.write mw molecule)
               (.close mw)
               (.toString w))))
