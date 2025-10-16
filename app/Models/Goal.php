<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Goal extends Model
{
    use HasFactory;

    protected $table = 'goal';

    protected $fillable = [
        'vitesse',
        'id_equipe',
        'id_match',
    ];

    // Le but appartient à une équipe
    public function equipe()
    {
        return $this->belongsTo(Team::class, 'id_equipe');
    }

    // Le but appartient à un match
    public function match()
    {
        return $this->belongsTo(Matches::class, 'id_match');
    }
}
