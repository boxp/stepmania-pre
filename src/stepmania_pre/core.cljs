(ns stepmania-pre.core 
  (:require [goog.graphics :as Graphics]))


; 初期化＆丸を描画
(defn initcircle [] 
  (do 
    ; 描画領域の初期化
    (def graphics (Graphics/createGraphics 512 512))
    ; 線の生成
    (def initialstroke 
      (Graphics/Stroke. 2,"#000000"))
    ; 塗りつぶしの生成
    (def initialfill 
      (Graphics/SolidFill. "#ffff00"))
    ; 丸の描画
    (.drawCircle graphics 200 200 100 initialstroke initialfill)
    (.render graphics js/circlecanvas)))

(set! (. js/window -onload) initcircle)
