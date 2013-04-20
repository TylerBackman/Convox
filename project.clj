(defproject Convox "1.0.0-SNAPSHOT"
  :description "A Functional cheminformatics library for Clojure/Incanter"
  :license {:name "GNU Lesser General Public License v3.0"
            :url "https://github.com/TylerBackman/Convox/blob/master/lgpl-3.0.txt"}
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [org.clojure/data.xml "0.0.7"]
                 [cdk/cdk "1.4.17"]]
  :repositories {"local" ~(str (.toURI (java.io.File. "maven_repository")))})
